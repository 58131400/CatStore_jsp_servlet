(function () {
	"use strict";
	window.addEventListener('load',function()
	{
		var forms = document.getElementsByClassName('needs-validation');
		
		var validation = Array.prototype.filter.call(forms, function(form){
			form.addEventListener('submit', function(event){
				if(form.checkValidity()===false)
				{
					event.preventDefault();
					event.stopPropagation();
				}

				form.classList.add('was-validated');
				// Neu muon kiem tra tung cot
				/*
				 * var x = forms["fCreateMay"]['id'].value; console.log("x la:
				 * ",x); if(x== '') {
				 * document.getElementById('id-feedback').innerHTML = "khong hop
				 * le"; }
				 */

			},false);
		});

	},false);

	 function load_listCat(catPage)
     {
         $.ajax({
             url: "/CatStore/home",
             method: "post",
             data: {catPage}, 
             success: function(data)
             {           	 
                 $('#cats-pill').html(data);
            	 
             }
         })
     }
	 load_listCat(1);
    $(document).on('click','#cat_pagination li',function()
     {
        var page = $(this).attr("id");   
        console.log("catPage:"+ page);       
        load_listCat(page);         
    })
    function load_listFood(foodPage)
     {
         $.ajax({
             url: "/CatStore/home",
             method: "post",
             data: {foodPage}, 
             success: function(data)
             {
            	 
                 $('#foods-pill').html(data);
            	 
             }
         })
     }
    load_listFood(1);
    $(document).on('click','#food_pagination li',function()
     {
        var page = $(this).attr("id");   
        console.log("page:"+ page);       
        load_listFood(page);         
    })
    function load_listFashion(fashionPage)
     {
         $.ajax({
             url: "/CatStore/home",
             method: "post",
             data: {fashionPage}, 
             success: function(data)
             {            	 
                 $('#fashions-pill').html(data);
            	 
             }
         })
     }
    load_listFashion(1);
    $(document).on('click','#fashion_pagination li',function()
     {
        var page = $(this).attr("id");   
        console.log("page:"+ page);       
        load_listFashion(page);         
    })
            
})();