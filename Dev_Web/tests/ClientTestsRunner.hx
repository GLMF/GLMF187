class ClientTestsRunner {
	public static function main() {
		framework.models.Object.wsRootURL = "/~fendres/gestact/";
		var tr = new haxe.unit.TestRunner();
		tr.add(new ContactCtrl());
		tr.run();
	}
}
