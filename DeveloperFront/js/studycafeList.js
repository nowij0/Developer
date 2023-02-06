$(()=>{
    $.ajax({
        xhrFields: {
            //크로스오리진 에러를 통과할수 있는 자격! 쿠키를 host가다른 url로 요청되어도 유지할 수 있게!
            withCredentials: true
         },
        url : backURL + 'studyroom/searchAll?orderBy=1',
        method:"GET",
        success:function(jsonObj){
            
            console.log(jsonObj)

            let origin = $('div.studycafe>searchgroup>form.search').first()
            let $parent = $origin.parent()
            $(jsonObj).each((index,cafe)=>{
                let imgPath=s.imgPath;
                let name=s.name;
                let addr=s.addr;
                let price=s.price;
                let person=s.person;
                let favCnt=s.cnt

                let $copy=$origin.clone()
                $copy.html(imgPath+":"+name+":"+addr+":"+price+":"+person+":"+favCnt)
                $parent.append($copy)
            })
        }  

    })


    // function showListBySearch(url){
    //     let $origin = $('div.studycafe').first()
    //     $('div.studycafe').not(':first-child').remove()
    //     $origin.show()

    //     $.ajax({
    //         url:backURL+'studyroom/search',
    //         method:'get',
    //         data : ,
    //         success: function (jsonObj){
    //             if(jsonObj.status <1){
    //                 alert(jsonObj.msg)
    //                 return
    //             }
    //             let $parent=$('div.studycafeList')

    //             $(list).each((index,s)=>{
    //                 let imgPath=s.imgPath;
    //                 let name=s.name;
    //                 let addr=s.addr;
    //                 let price=s.price;
    //                 let person=s.person;
    //                 let favCnt=s.cnt
    //                 let copy=$origin.clone();


    //                 let $imgObj = $('<img>')
    //                 $imgObj.attr('src','../images/'+imgPath+'.jpg')
    //                 $copy.find('div.img').empty().append($imgObj)
    //                 $copy.find('div.name').html(name)
    //                 $copy.find('div.price').html(price + '원/시간')
    //                 $copy.find('div.person').html('최대 '+person+'인')
    //                 $copy.find('div.favCnt').html(favCnt)

    //             })
    //             $origin.hide()

    //         },
    //         error: function(xhr){
    //             // alert(xhr.status)
    //             let jsonObj = JSON.parse(xhr.reponseText)
    //             alert(jsonObj)
    //         }
    //     })


    

})