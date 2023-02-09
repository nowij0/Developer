//=== 기본적인 페이지 상세 내용 보여주기 START ===
$(()=>{
    let url = backURL + 'lesson/detail';
    let data = "lessonSeq=1";
    $('#lessonDetail > div.lessonReview').hide();
    $('#lessonDetail > div.ask').hide();

    $.ajax({
        url : url,
        data: data,
        success: function(jsonObj){
            $('#detail > div.imgPath').html(jsonObj[0].imgPath)
            $('#detail > div.category').html(jsonObj[0].category)
            $('#detail > div.lessonName').html(jsonObj[0].lessonName)
            $('#detail > div.tutorName').html(jsonObj[0].tutorVO.usersVO.name)
            $('#detail > div.category').html(jsonObj[0].category)
            $('#detail > div.price').html(jsonObj[0].price)
            $('#detail > div.location').html(jsonObj[0].location)
            $('#detail > div.people').html(jsonObj[0].people)
            $('#detail > div.cDate').html(jsonObj[0].startCdate + " ~ " + jsonObj[0].endCdate )
            $('#detail > div.date').html(jsonObj[0].startDate + " ~ " + jsonObj[0].endDate)
            $('#lessonDetail > div.detail').html(jsonObj[0].content)
        }, 
        error: function(xhr){
            let jsonObj = JSON.parse(xhr.responseText);
            alert(jsonObj.msg);
        }
    });
});
//=== 기본적인 페이지 상세 내용 보여주기 END ===

//=== 상세정보 보여주기 START ===
$(document).on('click', '#detailbtn', function(){
    $('#lessonDetail > div.detail').show();
    $('#lessonDetail > div.lessonReview').hide();
    $('#lessonDetail > div.ask').hide();
});
//=== 상세정보 보여주기 END ===

//=== 문의하기 보여주기 START ===
$(document).on('click', '#askbtn', function(){
    $('#lessonDetail > div.detail').hide();
    $('#lessonDetail > div.lessonReview').hide();
    $('#lessonDetail > div.ask').show();
});
//=== 문의하기 보여주기 END ===

//=== 수강평 보여주기 START ===
$(document).on('click', '#lessonReviewbtn', function(){
    $('#lessonDetail > div.detail').hide();
    $('#lessonDetail > div.lessonReview').show();
    $('#lessonDetail > div.ask').hide();
    
    url = backURL + 'lesson/review';
    data = "lessonSeq=1";
    console.log(url)

    $.ajax({
        url : url,
        data: data,
        success: function(jsonObj){
            $('#lessonDetail > div.lessonReview > div.star').html(jsonObj[0].star)
            $('#lessonDetail > div.lessonReview > div.nickname').html(jsonObj[0].nickname)
            $('#lessonDetail > div.lessonReview > div.review').html(jsonObj[0].review)
        }, 
        error: function(xhr){
            let jsonObj = JSON.parse(xhr.responseText);
            alert(jsonObj.msg);
        }
    });
});
//=== 수강평 보여주기 END ===

//=== 강사명 누르면 페이지 이동 START
$(document).on('click', '#detail > div.tutorName', function(){
    location.href = frontURL + 'lesson/tutorinfo.html';
});
//=== 강사명 누르면 페이지 이동 END