const sbtnsBox = document.querySelector(".operations__users--btns");
const sbtnValues = ["New Purchase","Purchase History", "Inventory and Stocks","Dealers Information","Customer Information"]

for(let i of sbtnValues){
    let sbtn = document.createElement("button");
    sbtn.classList.add("sbtns");
    sbtn.innerText = i;
    sbtnsBox.append(sbtn);
}

sbtnsBox.addEventListener("click",(e)=>{
    switch(e.path[0].innerText){
        case "New Purchase":
            // window.open("/Purchase","_self");
            window.open("/Purchase","_self");
            break;

        case "Purchase History":
            window.open("/PurchaseHistory","_self");
            break;

        case "Dealers Information":
            window.open("/Dealer","_self");
            break;

        case "Customer Information":
            window.open("/Customer","_self");
            break;

        case "Inventory and Stocks":
            window.open("/Item","_self");
            break;

        default:
            break;
    }


})
