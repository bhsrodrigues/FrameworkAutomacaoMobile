package estudos.frameworkautomacaoapp.specs;

import org.junit.Assert;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import estudos.frameworkautomacaoapp.core.BaseTest;
import estudos.frameworkautomacaoapp.pages.HomePage;
import estudos.frameworkautomacaoapp.pages.ProductPage;
import estudos.frameworkautomacaoapp.pages.SearchPage;

public class Amazon {
	
	private HomePage home = new HomePage();
	private SearchPage search = new SearchPage();
	private ProductPage product = new ProductPage();
	private String sproduct;
	
	@Dado("^que eu acesse o site da Amazon Brasil$")
	public void que_eu_acesse_o_site_da_Amazon_Brasil() throws Throwable {
	    home.skipLogin();
	}

	@Quando("^pesquiso o produto \"([^\"]*)\"$")
	public void pesquiso_o_produto(String product) throws Throwable {
	    this.sproduct = product;
		home.searchField(product);
	    Thread.sleep(5000);
	}

	@Quando("^seleciono um dos itens pesquisados$")
	public void seleciono_um_dos_itens_pesquisados() throws Throwable {
	    search.clickInFirstItem();
	}

	@Quando("^adiciono no carrinho$")
	public void adiciono_no_carrinho() throws Throwable {
	    product.addToCart();
	}

	@Então("^ao consultar na sacola o produto será exibido$")
	public void ao_consultar_na_sacola_o_produto_será_exibido() throws Throwable {
	    product.seeCart();
	    BaseTest.takeScreenshot();
	    Assert.assertTrue(product.validateItem(sproduct));
	}
}
