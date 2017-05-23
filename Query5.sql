/*5*/
SELECT c.lastName, c.firstName,  r.user_role, c.cus_loginName, c.cus_password, c.cus_username, c.cus_DOB, 
	   b.trans_cost, b.trans_descrip, b.trans_quantity, 
       s.modelName, s.modelYear, s.modelType, s.maxCapacity, s.price, s.image_url, s.fuelCapacity
FROM sp17_3308_tug25055.customer as c, sp17_3308_tug25055.buys as b, sp17_3308_tug25055.spaceship as s, sp17_3308_tug25055.user_role as r
WHERE c.user_role_id = r.user_role_id AND c.customer_id = b.customer_id AND s.spaceship_id = b.spaceship_id
ORDER BY c.lastName, c.firstName;