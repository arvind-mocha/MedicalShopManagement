const addbtn = document.querySelector(".add__btn");
const addbox = document.querySelector(".icontainer");
const items = document.querySelector(".add");
const form = document.getElementById("purchase")

addbtn.addEventListener('click',()=>{{
    const item = items.cloneNode(true)
    items.after(item)
}})

form.addEventListener("submit", (e) => {
    const val = document.querySelector(".icontainer");
    e.preventDefault();
    const data ={
        name : "",
        expiry : "",
        price : "",
        quantity : "",
        date: document.querySelector(".extra__info").value,
        dealer: document.querySelector(".search__input").value
    }


    for(let i of val.children){
        data.name += i.children[0].children[1].value+",";
        data.expiry += i.children[1].children[1].value+",";
        data.price += i.children[2].children[1].value+",";
        data.quantity += i.children[3].children[1].value+",";
    }

    fetch('http://localhost:8080/Purchase', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    }).then()

    alert("Purchase Order as been placed successfully")
    window.location.reload();
})