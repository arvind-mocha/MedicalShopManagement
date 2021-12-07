// const vendors = async ()=>{
//     const select = document.querySelector("#DealerName")
//     const res = await fetch('/Dealer');
//     let res1 = await res.json()
//     res1 = [{"DealerName":null},...res1]
//     for(let i of res1){
//         const options = document.createElement("option")
//         options.innerText = i.DealerName;
//         select.append(options);
//     }
// }
//
// vendors()

const tbody = document.querySelector('tbody');
tbody.addEventListener('click',(e)=>{
    alert("The Status Will Be changed to Success")
    const data = {
        "id":e.path[1].children[0].innerText,
        "msg":"Success"
    }

    fetch("http://localhost:8080/PurchaseHistory", {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    }).then(res=> window.location.reload())
})



