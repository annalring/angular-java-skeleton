package app.dhojsw.ng;

import app.dhojsw.ng.command.CommandComponent;
import app.dhojsw.ng.my.MyComponent;
import app.dhojsw.ng.service.Logger;
import app.dhojsw.ng.stock.StockDetailComponent;
import app.dhojsw.ng.stock.StockListComponent;
import def.angular.common_http.HttpClientModule;
import def.angular.core.NgModule;
import def.angular.forms.FormsModule;
import def.angular.platform_browser.BrowserModule;

/**
 * TODO show error info when bootstrap .
 * 
 * @author wu
 *
 */
@NgModule(//
		imports = { //
				BrowserModule.class, //
				FormsModule.class, //
				HttpClientModule.class, //
				RouterModule_forRoot_REPLACEHOLDER.class //
		}, //

		declarations = { //
				AppComponent.class, //
				MyComponent.class, //
				CommandComponent.class, //
				StockListComponent.class, //
				StockDetailComponent.class, //
				PageNotFoundComponent.class //
		}, //
		bootstrap = { AppComponent.class }, //
		providers = { Logger.class }//
)
public class AppModule {

}