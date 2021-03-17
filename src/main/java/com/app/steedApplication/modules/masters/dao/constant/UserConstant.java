package com.app.steedApplication.modules.masters.dao.constant;

public interface UserConstant {
	
//	String Change_PWD_Update = "UPDATE user AS u SET u.pwdtobechanged = 'N',u.expirydate = DATE(NOW() + INTERVAL 3 MONTH),u.modified_by =:userName,u.modified_date = now() WHERE u.username =:userName";
	String Change_PWD_Update = "UPDATE user AS u SET u.password = AES_ENCRYPT(:password,'o2web_ng'),u.pwdtobechanged = 'N',u.expirydate = DATE(NOW() + INTERVAL 3 MONTH),u.modified_by =:userName,u.modified_date = now() WHERE u.username =:userName";
	
	String Forgot_PWD_Update = "UPDATE user AS u SET u.pwdtobechanged = 'Y',u.modified_by =:userName,u.modified_date = now() WHERE u.username =:userName";
	
	String GET_MENU = "select m.display_name as displayName, m.menu_icon as menuIcon, m.data_page as dataPage, m.parent_menu as parentMenu from menus as m, user_roles as ur, user_role_access as ura where m.status = 'Y' and ur.status = 'Y' and ura.status = 'Y' and ura.read_access = 'Y' and m.menu_id = ura.screen_id and ura.role_id = ur.role_id and m.menu_type = 'web' and ur.role_name =:userType";
	
	String USER_HISTROY = "insert into user_history (id,ref_code,company_code,distributor_code,ba_retailer_code,brand_code,device_id,salesman_code,phone_number,email,user_id,username,user_type,password,status,display_name,pwdtobechanged,expirydate,employee_number,erp_user_id,employee_id,report_to,expense_approver,expense_approval_limit,modified_by,modified_date,moved_by,moved_on) select id,ref_code,company_code,distributor_code,ba_retailer_code,brand_code,device_id,salesman_code,phone_number,email,user_id,username,user_type,password,status,display_name,pwdtobechanged,expirydate,employee_number,erp_user_id,employee_id,report_to,expense_approver,expense_approval_limit,modified_by,modified_date,:movedby,:movedon from user where id =:id";
	
	String SALESMAN_HISTROY = "insert into salesman_histroy (salesman_id,distributor_code,salesman_code,salesman_name,brand_code,employee_number,salesman_address_1,salesman_address_2,salesman_address_3,country,state,city,is_Active,user_code,is_company_salesman,salesman_hierarchy_level,salesman_hierarchy_path,geo_path_mapped,is_user,multiple_route,team_name_list,modified_date,modified_by,moved_by,moved_on) select salesman_id,distributor_code,salesman_code,salesman_name,brand_code,employee_number,salesman_address_1,salesman_address_2,salesman_address_3,country,state,city,is_Active,user_code,is_company_salesman,salesman_hierarchy_level,salesman_hierarchy_path,geo_path_mapped,is_user,multiple_route,team_name_list,modified_date,modified_by,:movedby,:movedon from salesman where salesman_code =:id"; 
	
	String USER_REPORTING_DETAILS_HISTROY = "insert into user_reporting_details_history (id,company_code,user_id,reporting_to_user_id,status,last_updated_by,last_updated_dtm,moved_by,moved_on) select id,company_code,user_id,reporting_to_user_id,status,last_updated_by,last_updated_dtm,:movedby,:movedon from user_reporting_details where user_id =:id";
	
	String USER_PREFERENCE_HISTROY = "insert into user_preference_history (id,company_code,user_id,language,display_image_order,status,last_updated_by,last_updated_dtm,moved_by,moved_on) select id,company_code,user_id,language,display_image_order,status,last_updated_by,last_updated_dtm,:movedby,:movedon from user_preference where user_id =:id";
	
	String UPDATE_USER_PASSWORD = "UPDATE user AS u SET u.password = AES_ENCRYPT(:password,'o2web_ng'),u.pwdtobechanged =:changeFlag,u.expirydate = DATE(NOW() + INTERVAL 3 MONTH),u.modified_by =:movedby,u.modified_date =:movedon WHERE u.id =:id AND u.company_code=:companyCode";
	
	String CHECK_OLD_PASSWORD = "SELECT COUNT(1) FROM user AS U WHERE U.company_code =:companyCode AND U.id =:id AND U.password = AES_ENCRYPT(:password,'o2web_ng')";
	
	String CHECK_PASSWORD_VALIDATION = "SELECT COUNT(1) FROM user AS U WHERE U.company_code =:companyCode AND U.id =:id AND (U.pwdtobechanged = 'Y' OR U.expirydate < :date)";
	
	String CHECK_OLD_PHONENO = "SELECT COUNT(1) FROM user AS U WHERE U.company_code =:companyCode AND U.id =:id AND U.phone_number =:phoneNumber";
}
