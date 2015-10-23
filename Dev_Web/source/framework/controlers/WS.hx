package framework.controlers;
import haxe.Json;
import haxe.ds.StringMap;
#if php
import php.Web;
#elseif neko
import neko.Web;
#end

class WS {
	public static function isWS() : Bool {
		return (-1 != Web.getClientHeader("Accept").indexOf("application/json"));
	}

	public static function getParams() : StringMap<String> {
		if (! isWS()) {
			return Web.getParams();
		} else {
			var params : StringMap<String> = new StringMap();
			try {
				var obj = Json.parse(Web.getPostData());
				for (field in Reflect.fields(obj)) {
					params.set(field, Reflect.field(obj, field));
				}
			} catch (error : Dynamic) {}
			return params;
		}
	}
}