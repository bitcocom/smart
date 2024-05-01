function bookList(){
    // GET : http://localhost:8081/weberp/api/books 요청
    // jQuery API ---> Ajax
    // 바닐라 자바스크립트 ---> API 사용하지 않고 기존에 있는 함수를 사용
    fetch("http://localhost:8081/weberp/api/books")
    .then(response=>response.json())
    .then(function(books){   // books -> [ {    }, {     },  {     }  ]
          let tbody=document.getElementById("tbody");
          let html="";
          books.forEach(function(book){
              html+="<tr>";
              html+="<td>"+book.num+"</td>";
              html+="<td>"+book.title+"</td>";
              html+="<td>"+book.price+"</td>";
              html+="<td>"+book.author+"</td>";
              html+="<td>"+book.page+"</td>";
              html+="</tr>";
          });
          tbody.innerHTML=html;
     })
    .catch(function(error){
        console.log("error:", error);
     });
}