let url = backURL + 'board/boardtype';
let url2 = backURL + 'board/boardsearch';

$(()=>{
    $.ajax({
        url:url,
        method:'get',
        data:'boardType=1',
        success : function(jsonObj){
           // console.log(jsonObj);
           // console.log(jsonObj[0].cDate);
           let boardData = "";
           let temp = "";

            $.each(jsonObj, function(index,item){
                console.log(jsonObj[index]);
  
                if(item.category == 0){
                    temp="Q/A";
                } else if(item.category == 1){
                    temp="스터디모집";
                } else if(item.category == 2){
                    temp="자유게시판"
                }
                boardData += "<div class='list-container'>";
                boardData += "<div class='title'> <a href='#'>"+item.title+"</a></div>";
                boardData += "<div class='content'>"+item.content+"</div>";
                boardData += "<div class='info'>";
                boardData += "<div class='subinfo1'>";
                boardData += "<span> 작성자 : "+item.nickname+"</span>";
                boardData += "<span> 작성일 : "+item.cDate+"</span>";
                boardData += "<span class='postCategory'> 카테고리 : "+temp+"</span>";
                boardData += "</div>";
                boardData += "<div class='subinfo2'>";
                boardData += "<span><i class='fa-solid fa-heart'></i> "+item.recommend+"</span> ";
                boardData += "<span><i class='fa-regular fa-eye'></i> "+item.cnt+"</span>";
                boardData += "</div>";
                boardData += "</div>";
                boardData += "</div>";
                
            });
            $("#list").append(boardData);
        },
        error : function(xhr){
            alert(xhr.status);
        }
    })


$('#descbtn').click(()=>{
    
    $.ajax({
        url:url,
        method:'get',
        data:'boardType=1',
        success : function(jsonObj){
           // console.log(jsonObj);
           // console.log(jsonObj[0].cDate);
           let boardData = "";
           let temp = "";
           $("#list").html("");

            $.each(jsonObj, function(index,item){
                console.log(jsonObj[index]);
  
                if(item.category == 0){
                    temp="Q/A";
                } else if(item.category == 1){
                    temp="스터디모집";
                } else if(item.category == 2){
                    temp="자유게시판"
                }
                boardData += "<div class='list-container'>";
                boardData += "<div class='title'> <a href='#'>"+item.title+"</a></div>";
                boardData += "<div class='content'>"+item.content+"</div>";
                boardData += "<div class='info'>";
                boardData += "<div class='subinfo1'>";
                boardData += "<span> 작성자 : "+item.nickname+"</span>";
                boardData += "<span> 작성일 : "+item.cDate+"</span>";
                boardData += "<span class='postCategory'> 카테고리 : "+temp+"</span>";
                boardData += "</div>";
                boardData += "<div class='subinfo2'>";
                boardData += "<span><i class='fa-solid fa-heart'></i> "+item.recommend+"</span> ";
                boardData += "<span><i class='fa-regular fa-eye'></i> "+item.cnt+"</span>";
                boardData += "</div>";
                boardData += "</div>";
                boardData += "</div>";

            });
            $("#list").append(boardData);
            
        },
        error : function(xhr){
            alert(xhr.status);
        }
    })
})

$('#cntbtn').click(()=>{
    $.ajax({
        url:url,
        method:'get',
        data:'boardType=2',
        success : function(jsonObj){
           // console.log(jsonObj);
           // console.log(jsonObj[0].cDate);
           let boardData = "";
           let temp = "";
           $("#list").html("");

            $.each(jsonObj, function(index,item){
                console.log(jsonObj[index]);
  
                if(item.category == 0){
                    temp="Q/A";
                } else if(item.category == 1){
                    temp="스터디모집";
                } else if(item.category == 2){
                    temp="자유게시판"
                }
                boardData += "<div class='list-container'>";
                boardData += "<div class='title'> <a href='#'>"+item.title+"</a></div>";
                boardData += "<div class='content'>"+item.content+"</div>";
                boardData += "<div class='info'>";
                boardData += "<div class='subinfo1'>";
                boardData += "<span> 작성자 : "+item.nickname+"</span>";
                boardData += "<span> 작성일 : "+item.cDate+"</span>";
                boardData += "<span class='postCategory'> 카테고리 : "+temp+"</span>";
                boardData += "</div>";
                boardData += "<div class='subinfo2'>";
                boardData += "<span><i class='fa-solid fa-heart'></i> "+item.recommend+"</span> ";
                boardData += "<span><i class='fa-regular fa-eye'></i> "+item.cnt+"</span>";
                boardData += "</div>";
                boardData += "</div>";
                boardData += "</div>";

            });
            $("#list").append(boardData);
            
        },
        error : function(xhr){
            alert(xhr.status);
        }
    })
})


$('#recbtn').click(()=>{
    
    $.ajax({
        url:url,
        method:'get',
        data:'boardType=3',
        success : function(jsonObj){
            // console.log(jsonObj);
            // console.log(jsonObj[0].cDate);
            let boardData = "";
            let temp = "";
            $("#list").html("");
            
            $.each(jsonObj, function(index,item){
                console.log(jsonObj[index]);
                
                if(item.category == 0){
                    temp="Q/A";
                } else if(item.category == 1){
                    temp="스터디모집";
                } else if(item.category == 2){
                    temp="자유게시판"
                }
                boardData += "<div class='list-container'>";
                boardData += "<div class='title'> <a href='#'>"+item.title+"</a></div>";
                boardData += "<div class='content'>"+item.content+"</div>";
                boardData += "<div class='info'>";
                boardData += "<div class='subinfo1'>";
                boardData += "<span> 작성자 : "+item.nickname+"</span>";
                boardData += "<span> 작성일 : "+item.cDate+"</span>";
                boardData += "<span class='postCategory'> 카테고리 : "+temp+"</span>";
                boardData += "</div>";
                boardData += "<div class='subinfo2'>";
                boardData += "<span><i class='fa-solid fa-heart'></i> "+item.recommend+"</span> ";
                boardData += "<span><i class='fa-regular fa-eye'></i> "+item.cnt+"</span>";
                boardData += "</div>";
                boardData += "</div>";
                boardData += "</div>";
                
            });
            $("#list").append(boardData);
            
        },
        error : function(xhr){
            alert(xhr.status);
        }
    })
})
$('#addbtn').on("click",function(){
    location.href= frontURL + "/addBoard.html";
});

    $('#searchbtn').click(()=>{
    alert('검색')
    // let para = document.location.href.split("?")[1];
    // console.log(para);
        let formData = new formData($('#'))
        $.ajax({
            url:url2,
            method:'post',
            data: $('#searchtitle').serialize(),
            success : function(jsonObj){
               
               let boardData = "";
               let temp = "";
               $("#list").html("");

               var para = document.location.href.split("?");
               console.log(para);
                $.each(jsonObj, function(index,item){
                    if(item.category == 0){
                        temp="Q/A";
                    } else if(item.category == 1){
                        temp="스터디모집";
                    } else if(item.category == 2){
                        temp="자유게시판"
                    }
                    boardData += "<div class='list-container'>";
                    boardData += "<div class='title'> <a href='#'>"+item.title+"</a></div>";
                    boardData += "<div class='content'>"+item.content+"</div>";
                    boardData += "<div class='info'>";
                    boardData += "<div class='subinfo1'>";
                    boardData += "<span> 작성자 : "+item.nickname+"</span>";
                    boardData += "<span> 작성일 : "+item.cDate+"</span>";
                    boardData += "<span class='postCategory'> 카테고리 : "+temp+"</span>";
                    boardData += "</div>";
                    boardData += "<div class='subinfo2'>";
                    boardData += "<span><i class='fa-solid fa-heart'></i> "+item.recommend+"</span> ";
                    boardData += "<span><i class='fa-regular fa-comment'></i> "+item.cnt+"</span>";
                    boardData += "</div>";
                    boardData += "</div>";
                    boardData += "</div>";
    
                });
                $("#list").append(boardData);
            },
            error : function(xhr){
                alert(xhr.status);
            }
        })
    })
    
})
