read()

function read(){
    $.ajax({
        async : false,
        method : 'GET' ,
        url : '/account/get' ,
        success : response => {
            let get = document.querySelector("#get");
            let html = "";
            response.forEach(o => {
                html += `${o.tmi} , ${o.price}, ${o.timer} <br>`;
            });
                get.innerHTML = html;
            }
        })
}

function add(){
    $.ajax({
        async : false,
        method : 'PUT',
        url : '/account/put',
        data : {
            tmi : document.querySelector("#puttmi").value,
            price : document.querySelector("#putprice").value,
            timer : document.querySelector("#putdate").value
        },
        success : response => {
            if(response == 1) read()
            else alert("Error")
        }
    })
}

function update(){
    $.ajax({
        async : false,
        method : 'POST',
        url : '/account/update',
        data : {
            id : document.querySelector("#updatenum").value,
            tmi : document.querySelector("#updatetmi").value,
            timer : document.querySelector("#updatedate").value
        },
        success : response => {
            if(response == 1) read()
            else alert("Error")
        }
    })
}

function deletee(){
    $.ajax({
        async : false,
        method : 'DELETE',
        url : '/account/delete',
        data : {
            id : document.querySelector("#delnum").value
        },
        success : response => {
            if(response == 1) read()
            else alert("Error")
        }
    })
}