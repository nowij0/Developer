$(()=>{

    //--첨부파일이 변경되었을때 할일 START--
    let $divShow = $('div.show')
    $('div.form>form>input[type=file]').change((e)=>{
        $(e.target.files).each(( index, imgFileObj)=>{
            // let imgFileObj = e.target.files[0]

            console.log(imgFileObj)
            //blob타입의 이미지파일객체내용을 문자열로 변환
            let blobStr = URL.createObjectURL(imgFileObj)
            // $('div.show>img').attr('src', blobStr)
            let img = $('<img>').attr('src', blobStr).css('margin-left', '10px')
            $divShow.append(img)
        })
    })
    //--첨부파일이 변경되었을때 할일 END--

  //폼 submit되었을 때 할일 start
  let $form = $('div.form>form')
  $form.submit(()=>{ //폼이 sumbit이되었을때 기본 이벤트 : 해당 url로 데이터를 보냄(아무것도 하지않아도)
      //폼태그의 action="url"로 자료를 보내는작업(기본이벤트) return false 로 처리하면 submit의 끝에 기본이벤트처리를 막음 

      let url = backURL + 'board/addboard'
      //ajax로 요청할 거라면! 자료가 하나라도 들어가면 반드시 data가 formData가 되어야 함 규칙
      //1.번 방법 let formData = new FormData()
      let formData = new FormData($form[0]);  //반드시 [0]으로 쓰라는 규약. 폼태그의 내용이 다들어감!
      //formData : 맵 자료구조 형태의 객체 
      formData.forEach((value, key)=>{
          console.log(key)
          console.log(value)
          console.log('----')
      })
      
      $.ajax({
        // xhrFields: {
        //     //크로스오리진 에러를 통과할수 있는 자격! 쿠키를 host가다른 url로 요청되어도 유지할 수 있게!
        //     withCredentials: true
        //  },
          url: url,
          method:'post',//파일업로드용 설정
          data : formData,//파일업로드용 설정
          processData : false,//파일업로드용 설정
          contentType : false,//파일업로드용 설정
          success: function(){

          },
          error: function(xhr){
              alert('오류'+ xhr.status)

          }
      })
      return false
  })
  //폼 submit되었을 때 할일 end
})