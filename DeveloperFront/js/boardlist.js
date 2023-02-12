let url = backURL + 'board/boardtype';
let url2 = backURL + 'board/boardsearch';

$(()=>{
    // 페이지 로드되었을시 목록 출력 START
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
// 페이지 로드되었을시 목록 출력 END

// 최신순 버튼 클릭되었을시 START
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
// 최신순 버튼 클릭되었을시 END

// 조회순 버튼 클릭되었을시 START
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
// 조회순 버튼 클릭되었을시 END

// 추천순 버튼 클릭되었을시 START
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
// 추천순 버튼 클릭되었을시 END

// 글쓰기 버튼 클릭되었을시 START
$('#addbtn').on("click",function(){
    location.href= frontURL + "addBoard.html";
});
// 글쓰기 버튼 클릭되었을시 END

// 제목으로 검색 했을 때 START
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
    // 제목으로 검색 했을 때 END

    //모달창 START
    function onClick() {
        document.querySelector('.modal_wrap').style.display ='block';
        document.querySelector('.black_bg').style.display ='block';
    }
    function offClick() {
        document.querySelector('.modal_wrap').style.display ='none';
        document.querySelector('.black_bg').style.display ='none';
    }
 
    document.getElementById('modal_btn').addEventListener('click', onClick);
    document.querySelector('.modal_close').addEventListener('click', offClick);

    $('#login').submit(()=>{
        alert('로그인');
    })
    //모달창 END
})
