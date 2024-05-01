// 등록버튼 클릭시 호출
function goRegister(){
    // 데이터를 가져오기
    let title=document.getElementById("title").value;
    let price=parseInt(document.getElementById("price").value);
    let author=document.getElementById("author").value;
    let page=parseInt(document.getElementById("page").value);
    let formData={  // javascript object -->JSON
         title:title,
         price:price,
         author:author,
         page:page
     };
     fetch("http://localhost:8081/weberp/api/books",{
           method : "POST",
           headers: { "Content-Type" : "application/json"  },
           body : JSON.stringify(formData)
      })
     .then(function(response){  // OK
            if(!response.ok){
                throw new Error("error not ok");
            }
            location.href="/weberp/restlist"; // 등록이 성공후 다시 리스트페이지로 이동
        })
     .catch(function(error){
            console.log("error:", error);
     });
}