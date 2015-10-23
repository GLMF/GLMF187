package framework.models;
import haxe.macro.Expr;
import haxe.macro.Context;

class ObjectStaticMethods {
	macro public static function add() : Array<Field> {
		var className : Expr = Context.makeExpr(Context.getLocalClass().toString(), Context.currentPos());
		var fields = Context.getBuildFields();

		var tDynamic : ComplexType = TPath({ pack : [], name : "Dynamic", params : [], sub : null });
		var tString : ComplexType = TPath({ pack : [], name : "String", params : [], sub : null });

		var fun : Function = { ret : tDynamic, args : [{ name : "cb", type : tDynamic, opt : false }],
			params: [], expr : macro return framework.models.Object.all($className, cb)};
		var field : Field = { pos : Context.currentPos(), name : "all", meta : [], doc : null,
			access : [APublic, AStatic], kind : FFun(fun)};
		fields.push(field);

		var fun : Function = { ret : tDynamic, args : [{ name : "key", type : tString, opt : false }, { name : "cb", type : tDynamic, opt : false }],
			params: [], expr : macro return framework.models.Object.get($className, key, cb)};
		var field : Field = { pos : Context.currentPos(), name : "get", meta : [], doc : null,
			access : [APublic, AStatic], kind : FFun(fun)};
		fields.push(field);

		return fields;
	}
}
