package jp.co.internous.plum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.plum.model.domain.MstProduct;
import jp.co.internous.plum.model.mapper.MstProductMapper;
import jp.co.internous.plum.model.session.LoginSession;

@Controller
@RequestMapping("/plum/product")
public class ProductController {

	@Autowired
	private MstProductMapper productMapper;

	@Autowired
	private LoginSession loginSession;

	@RequestMapping("/{id}")
	public String index(@PathVariable("id") int id, Model m) {

		/*
		 * "productMapper.findById(id)"を使用して、指定されたIDを持つ商品をデータベースから検索。
		 * idを抽出して/{id}のURLのリクエストをする。
		 */
		MstProduct product = productMapper.findById(id);

		/*
		 * "product"オブジェクトをtymeleafのModelに追加。
		 * これにより、tymeleafテンプレート内で"product"オブジェクトにアクセス可能。
		 * 
		 * "loginSession"オブジェクトをtymeleafのModelに追加。
		 * これにより、tymeleafテンプレート内で"loginSession"オブジェクトにアクセス可能。
		 */
		m.addAttribute("product", product);
		m.addAttribute("loginSession", loginSession);

		/* product_detail.htmlを表示する。 */
		return "product_detail";

	}
}
