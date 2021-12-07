const quantity = document.querySelector(".items__info");
const item = document.querySelector(".search__item");
const price = document.querySelector(".uprice");
const total = document.querySelector(".utotal");
const form = document.querySelector(".purchase");

function clear(){
    price.innerText= ""
    total.innerText = ""
}
['click','keyup'].forEach( evt =>
    quantity.addEventListener(evt, (e) =>{
        clear()
        fetch("http://localhost:8080/ItemJsonServlet?ItemName=" + item.value)
            .then(response => response.json())
            .then(data => {
                if(parseInt(quantity.value) < parseInt(data[0].AvailableStock)) {
                    price.innerText = data[0].PricePerUnit;
                    if (parseInt(quantity.value) > 0) {
                        total.innerHTML = parseInt(data[0].PricePerUnit) * parseInt(quantity.value);

                    }
                }else if (parseInt(quantity.value) > parseInt(data[0].AvailableStock)){
                    alert("Quantity is more than Available Stock")
                    clear()
                    quantity.value = ""
                }
            } );
    }),false
);


form.addEventListener('submit',()=>{
    alert("Purchase Done Successfully")
    window.open("/CustomerPortal");
})

