package controlers;
import framework.controlers.WS;
import haxe.Template;
import haxe.Resource;
import haxe.ds.StringMap;
#if php
import php.Web;
#elseif neko
import neko.Web;
#end
import models.Contact;
import haxe.Json;

class ContactCtrl {
		public function new(id : Int) {
		switch (Web.getMethod()) {
			case "GET":
				if (null == id) retrieveAll();
				else retrieveItem(id);
			case "POST":
				if (0 == id) create(WS.getParams());
				else {
					if (0 == Web.getPostData().length) delete(id);
					else update(id, WS.getParams());
				}
			case "PUT": update(id, WS.getParams());
			case "DELETE": delete(id);
			default: Web.setReturnCode(405); //method not allowed
		}
	}

	function create(data : StringMap<String>) {
		var c : Contact = new Contact(data.get("firstname"), data.get("lastname"), data.get("email"), data.get("phone"));
		if (("" == c.firstname || null == c.firstname) || ("" == c.lastname || null == c.lastname)) {
			Web.setReturnCode(400); //bad request
			Sys.println("missing 'firsname' or 'lastname'");
		} else {
			c.insert();
			if (WS.isWS()) {
				Web.setHeader("Content-Type", "application/json");
				Sys.println("{\"id\":" + c.id + "}");
			} else {
				Web.redirect("?/contacts");
			}
		}
	}
	
	function retrieveItem(id : Int) {
		var data : Contact;
		if (0 == id) data = new Contact("", "");
		else data = Contact.manager.get(id);
		if (null == data) Web.setReturnCode(404); //not found
		else {
			if (WS.isWS()) {
				Reflect.deleteField(data, "_lock");
				Reflect.deleteField(data, "__cache__");
				Web.setHeader("Content-Type", "application/json");
				Sys.println(Json.stringify(data));
			} else {
				var tpl = new Template(Resource.getString("contact-edit"));
				Sys.println(tpl.execute(data));
			}
		}
	}
	
	function retrieveAll() {
		var data : Array<Contact> = Lambda.array(Contact.manager.all());
		if (WS.isWS()) {
			Web.setHeader("Content-Type", "application/json");
			Sys.println("[");
			for (i in 0...data.length) {
				if (i != 0) Sys.println(",");
				Sys.println("{\"id\":" + data[i].id + ",\"firstname\":\"" + data[i].firstname + "\",\"lastname\":\"" + data[i].lastname + "\"}");
			}
			Sys.println("]");
		} else {
			var tpl = new Template(Resource.getString("contacts-list"));
			Sys.println(tpl.execute({ Contact : data }));
		}
	}
	
	function update(id : Int, data : StringMap<String>) {
		var c : Contact = Contact.manager.get(id);
		if (null == c) Web.setReturnCode(404); //not found
		else {
			c.firstname = data.get("firstname");
			c.lastname = data.get("lastname");
			c.email = data.get("email");
			c.phone = data.get("phone");
			c.update();
			if (! WS.isWS()) {
				Web.redirect("?/contacts");
			}
		}
	}
	
	function delete(id : Int) {
		var c : Contact = Contact.manager.get(id);
		if (null == c) Web.setReturnCode(404); //not found
		else {
			c.delete();
			if (! WS.isWS()) {
				Web.redirect("?/contacts");
			}
		}
	}
}
