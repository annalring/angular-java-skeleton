package app.dhojsw.ng.stock;

import app.dhojsw.ng.service.Logger;
import app.dhojsw.ng.support.AbstractDataResponseComponent;
import app.dhojsw.ng.support.JsonResponse;
import def.angular.common_http.HttpClient;
import def.angular.core.Component;
import def.angular.core.OnInit;

@Component(templateUrl = "./StockListComponent.html", //
		styleUrls = { "./StockListComponent.css" })

public class StockListComponent extends AbstractDataResponseComponent<JsonResponse> implements OnInit {

	public StockListComponent(HttpClient http, Logger log) {
		super(http, "/web/stocks/", log);
	}

	@Override
	protected Object newRequestBody() {
		return "";
	}

	@Override
	protected JsonResponse newResponse(double requestTime, Object reqBody, Object json) {

		return new JsonResponse(requestTime, json);
	}

	@Override
	public void ngOnInit() {
		// TODO Auto-generated method stub

	}

}
