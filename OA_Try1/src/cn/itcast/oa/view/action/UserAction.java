package cn.itcast.oa.view.action;

import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.User;
@Controller
public class UserAction extends BaseAction<User>{
	
	/** 列表 */
	public String list() throws Exception {
		userService.findAll();
		return "list";
	}

	/** 删除 */
	public String delete() throws Exception {
		return "toList";
	}

	/** 添加页面 */
	public String addUI() throws Exception {
		return "saveUI";
	}

	/** 添加 */
	public String add() throws Exception {
		return "toList";
	}

	/** 修改页面 */
	public String editUI() throws Exception {
		return "saveUI";
	}

	/** 修改 */
	public String edit() throws Exception {
		return "toList";
	}

}
