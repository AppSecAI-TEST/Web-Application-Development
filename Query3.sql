/*3*/
select  b.trans_date, s.modelName,  b.trans_cost, b.trans_quantity, b.trans_descrip,  
		 s.modelType, s.modelYear,  s.price, 
        s.maxCapacity, s.fuelCapacity, s.image_url
from sp17_3308_tug25055.spaceship as s, sp17_3308_tug25055.buys as b 
where s.spaceship_id = b.spaceship_id
order by  b.trans_date, s.modelName;