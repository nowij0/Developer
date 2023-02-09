//=== 튜터 상세 내용 보여주기 START ===
$(()=>{
    let url = backURL + 'lesson/tutorinfo';
    let data = "userId=autumn";
    
    $.ajax({
        url : url,
        data: data,
        success: function(jsonObj){
            console.log(jsonObj) 
            $('#tutor > div.tImgPath').html(jsonObj[0].tutorVO.imgPath)
            $('#tutor > div.tutorName').html(jsonObj[0].tutorVO.usersVO.name)
            $('#tutor > div.starAvg').html(jsonObj[0].tutorVO.starAvg)
            $('#tutor > div.info').html(jsonObj[0].tutorVO.info)

            let $origin = $('#tutorLesson').first();
            let $parent = $('#tutorLessonList');
            $(jsonObj).each((index)=>{
                let lImgPath = jsonObj[index].imgPath
                let lessonName = jsonObj[index].lessonName
                let location = jsonObj[index].location
                let price = jsonObj[index].price
                console.log(price)
                
                let $copy = $origin.clone();
                $copy.find('div.lImgPath').html(lImgPath);
                $copy.find('div.lessonName').html(lessonName);
                $copy.find('div.location').html(location);
                $copy.find('div.price').html(price);

                $parent.append($copy);
            })
            $origin.hide();
        }, 
        error: function(xhr){
            let jsonObj = JSON.parse(xhr.responseText);
            alert(jsonObj.msg);
        }
    });
});
//=== 튜터 상세 내용 보여주기 END ===