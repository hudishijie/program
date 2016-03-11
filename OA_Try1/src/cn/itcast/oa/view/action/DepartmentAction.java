package cn.itcast.oa.view.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Department;

@Controller
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department> {
	
	private Long parentId;

	/** 列表 */
	public String list() throws Exception {
		// 准备列表数据
		List<Department> departmentList = departmentService.findAll();
		ActionContext.getContext().put("departmentList", departmentList);
		return "list";
	}

	/** 删除 */
	public String delete() throws Exception {
		departmentService.delete(model.getId());
		return "toList";
	}

	/** 添加页面 */
	public String addUI() throws Exception {
		// 准备上级部门数据
		List<Department> departmentList = departmentService.findAll();
		ActionContext.getContext().put("departmentList", departmentList);

		return "saveUI";
	}

	/** 添加 */
	public String add() throws Exception {
		//设置上级部门
		model.setParent(departmentService.getById(parentId));
		//保存到数据库
		departmentService.save(model);
		return "toList";
	}

	/** 修改页面 */
	public String editUI() throws Exception {
		// 准备回显数据
		Department department = departmentService.getById(model.getId());
		parentId = department.getParent().getId();
		ActionContext.getContext().getValueStack().push(department);

		// 准备上级部门数据
		List<Department> departmentList = departmentService.findAll();
		ActionContext.getContext().put("departmentList", departmentList);

		return "saveUI";
	}

	/** 修改 */
	public String edit() throws Exception {
		// 取出要修改的岗位
		Department department = departmentService.getById(model.getId());
		// 修改数据
		department.setName(model.getName());
		department.setDescription(model.getDescription());
		department.setParent(departmentService.getById(parentId));
		// 更新到数据库
		departmentService.update(department);
		return "toList";
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

}
