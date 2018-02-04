package app.dhojsw.ng.command;

import static def.dhojsw.jsnative.Globals.js_isNumber;

import app.dhojsw.ng.service.Logger;
import def.angular.common_http.HttpClient;
import def.angular.core.Component;
import def.js.Array;
import def.js.PropertyDescriptor;
import def.rxjs.rxjs.Observable;

@Component(//		
		templateUrl = "./command.component.html", //
		styleUrls = { "./command.component.css" }//
)

public class CommandComponent {
	public String title;
	public String command;
	public Array<CommandResponse> responseArray = new Array<>();
	String url = "/web/cmd/";
	HttpClient http;
	Logger log;

	public CommandComponent(HttpClient http, Logger log) {
		this.title = "Command Component";
		this.http = http;
		this.log = log;
	}

	public void onResponse(double requestTime, String command, Object json) {
		PropertyDescriptor typeP = def.js.Object.getOwnPropertyDescriptor(json, "type");
		String type = (String) typeP.value;
		log.debug("type:" + type);
		CommandResponse rt = new CommandResponse(requestTime, command, json);
		this.responseArray.unshift(rt);
	}

	public void onButtonClick() {
		// console.log( "on Button Click,command:" + this.command );
		String command = this.command;
		double requestTime = def.js.Date.now();
		Observable<Object> ores = this.http.post(this.url, command);

		ores.toPromise().then((json) -> {
			log.debug(json);
			this.onResponse(requestTime, command, json);
			log.debug("post response:" + json);
			return null;
		})._catch((Object t) -> {
			log.error("catched exception");
			log.error(t);
			return null;
		});
	}

	public boolean showChart() {
		return true;
	}

	public boolean isNumber(Object json) {
		return js_isNumber(json);
	}
}
