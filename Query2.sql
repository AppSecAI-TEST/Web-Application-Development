/*2*/
SELECT r.user_role, r.user_role_id, c.cus_loginName, c.firstName, c.lastName, c.customer_id, c.cus_username, c.cus_password, c.cus_DOB
FROM sp17_3308_tug25055.customer as c,  sp17_3308_tug25055.user_role as r 
WHERE c.user_role_id = r.user_role_id
order by r.user_role, c.cus_loginName; 