package app.dhojsw.ng.stock;

import app.dhojsw.ng.service.Logger;
import app.dhojsw.ng.support.AbstractDataResponseComponent;
import app.dhojsw.ng.support.JsonResponse;
import def.angular.common_http.HttpClient;
import def.angular.core.Component;
import def.angular.core.OnInit;
import def.angular.router.ActivatedRoute;

@Component(templateUrl = "./StockDetailComponent.html", //
		styleUrls = { "./StockDetailComponent.css" })

public class StockDetailComponent extends AbstractDataResponseComponent<JsonResponse> implements OnInit {

	// public Observable<String> stockId$;
	public String stockId;
	ActivatedRoute route;

	public StockDetailComponent(HttpClient http, Logger log) {
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
		this.route.paramMap.toPromise().then((map) -> {
			stockId = map.get("id"); 
		});
		
		// this.stockId$ = this.route.paramMap.switchMap((params: ParamMap) =>
		// this.service.getHero(params.get('id')));
	}

}
