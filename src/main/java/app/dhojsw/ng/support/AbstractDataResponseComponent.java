package app.dhojsw.ng.support;

import static def.dhojsw.jsnative.Globals.js_isNumber;

import app.dhojsw.ng.service.Logger;
import def.angular.common_http.HttpClient;
import def.angular.core.OnInit;
import def.js.Array;
import def.js.PropertyDescriptor;
import def.rxjs.rxjs.Observable;

public abstract class AbstractDataResponseComponent<T extends JsonResponse> {

	String url;
	HttpClient http;
	Logger log;
	public Array<T> responseArray = new Array<>();
	public AbstractDataResponseComponent(HttpClient http, String url, Logger log) {
		this.http = http;
		this.url = url;
		this.log = log;
	}

	@SuppressWarnings("unchecked")
	public void onResponse(double requestTime, Object reqBody, Object json) {
		PropertyDescriptor typeP = def.js.Object.getOwnPropertyDescriptor(json, "type");
		String type = (String) typeP.value;
		log.debug("type:" + type);
		T rt = newResponse(requestTime, reqBody, json);
		this.responseArray.unshift(rt);
	}
	
	protected abstract Object newRequestBody();
	
	protected abstract T newResponse(double requestTime,Object reqBody, Object json);

	public void onButtonClick() {
		// console.log( "on Button Click,command:" + this.command );
		
		double requestTime = def.js.Date.now();
		Object body = this.newRequestBody();
		Observable<Object> ores = this.http.post(this.url, body);

		ores.toPromise().then((json) -> {
			log.debug(json);
			this.onResponse(requestTime, body, json);
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
