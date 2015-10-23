package framework.models;
import haxe.Json;
import js.html.XMLHttpRequest;
using StringTools;
typedef SId = Int;

@:autoBuild(framework.models.ObjectStaticMethods.add()) class Object {
	public static var wsRootURL : String = "/";

	public function new() {}

	public function insert(cb: Void -> Void) {
		var req = new XMLHttpRequest();
		var url : String = wsRootURL + "?/" + getClassURL(getClassName()) + "/" + getKey();
		if (null == cb) req.open("POST", url, false);
		else {
			req.open("POST", url, true);
			req.onreadystatechange = function() {
				if (4 == req.readyState && 200 == req.status) { setAutoId(req); cb(); }
			};
		}
		req.setRequestHeader("Accept", "application/json");
		req.setRequestHeader("Content-Type", "application/json");
		req.send(Json.stringify(this));
		if (null == cb && 200 == req.status) setAutoId(req);
	}

	static function get(className : String, key : String, cb: Dynamic -> Void) : Dynamic {
		var req = new XMLHttpRequest();
		var url : String = wsRootURL + "?/" + getClassURL(className) + "/" + key;
		if (null == cb) req.open("GET", url, false);
		else {
			req.open("GET", url, true);
			req.onreadystatechange = function() {
				if (4 == req.readyState && 200 == req.status) cb(buildObject(className, req.responseText));
			};
		}
		req.setRequestHeader("Accept", "application/json");
		req.send();
		if (null == cb && 200 == req.status) return buildObject(className, req.responseText);
		else return null;
	}

	static function all(className : String, cb: Dynamic -> Void) : Array<Dynamic> {
		var req = new XMLHttpRequest();
		var url : String = wsRootURL + "?/" + getClassURL(className);
		if (null == cb) req.open("GET", url, false);
		else {
			req.open("GET", url, true);
			req.onreadystatechange = function() {
				if (4 == req.readyState && 200 == req.status) cb(Json.parse(req.responseText));
			};
		}
		req.setRequestHeader("Accept", "application/json");
		req.send();
		if (null == cb && 200 == req.status) return Json.parse(req.responseText);
		else return null;
	}

	public function update(cb: Void -> Void) {
		var req = new XMLHttpRequest();
		var url : String = wsRootURL + "?/" + getClassURL(getClassName()) + "/" + getKey();
		if (null == cb) req.open("POST", url, false); //PUT (empty Web.getPostData() on Neko target with PUT)
		else {
			req.open("POST", url, true); //PUT
			req.onreadystatechange = function() {
				if (4 == req.readyState && 200 == req.status) cb();
			};
		}
		req.setRequestHeader("Accept", "application/json");
		req.setRequestHeader("Content-Type", "application/json");
		req.send(Json.stringify(this));
	}

	public function delete(cb: Void -> Void) {
		var req = new XMLHttpRequest();
		var url : String = wsRootURL + "?/" + getClassURL(getClassName()) + "/" + getKey();
		if (null == cb) req.open("DELETE", url, false);
		else {
			req.open("DELETE", url, true);
			req.onreadystatechange = function() {
				if (4 == req.readyState && 200 == req.status) cb();
			};
		}
		req.setRequestHeader("Accept", "application/json");
		req.send();
	}

	function getClassName() : String {
		return Type.getClassName(Type.getClass(this));
	}

	static function getClassURL(className : String) {
		return className.substring(className.lastIndexOf(".") + 1, className.length).toLowerCase() + "s";
	}

	function getKey() : String {
		var id : String = Reflect.field(this, "id");
		if (null == id) return "0";
		else return id;
	}

	function setAutoId(req : XMLHttpRequest) {
		if (null == Reflect.field(this, "id")) {
			Reflect.setField(this, "id", Json.parse(req.responseText).id);
		}
	}

	static function buildObject(className : String, jsonData : String) : Dynamic {
		var objClass : Dynamic = Type.resolveClass(className);
		var objData : Dynamic = Json.parse(jsonData);
		var obj : Dynamic = Type.createEmptyInstance(objClass);
		for (field in Reflect.fields(objData)) {
			Reflect.setField(obj, field, Reflect.field(objData, field));
		}
		return obj;
	}
}
