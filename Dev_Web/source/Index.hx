import sys.db.Manager;
#if php
import php.db.PDO;
import php.Web;
#elseif neko
import neko.Web;
import sys.db.Sqlite;
//~ import sys.db.Mysql;
#end
import models.Contact;
import haxe.web.Dispatch;
import haxe.ds.StringMap;

class Router {
	public function new() {}
	
	function doDefault() {
		Web.redirect("?/contacts");
	}
	
	function doContacts(?id : Int = null) {
		new controlers.ContactCtrl(id);
	}
}

class Index {
	public static function main() {
		Manager.initialize();
		#if php
		Manager.cnx = PDO.open("sqlite:" + Web.getCwd() + "data/db.sqlite");
		//~ sys.db.Manager.cnx = PDO.open("mysql:host=localhost;dbname=nom_bd", "login_sql", "mdp");
		#elseif neko
		Manager.cnx = Sqlite.open("data/db.sqlite");
		//~ Manager.cnx = Mysql.connect({user:"login_sql", pass:"mdp", host:"localhost", database:"nom_bd"});
		#end
			
		if (! sys.db.TableCreate.exists(Contact.manager)) {
			sys.db.TableCreate.create(Contact.manager);
			var c : Contact;
			c = new Contact("Leto", "Atreides", "leto@atreides.dune", "9876543210");
			c.insert();
			c = new Contact("Liet", "Kynes");
			c.insert();
		}
		
		try {
			Dispatch.run(Web.getParamsString(), new StringMap(), new Router());
		} catch (e : DispatchError) {
			Web.setReturnCode(400); //bad request
		}
		Manager.cnx.close();
	}
}
