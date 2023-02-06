package com.developer.board.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.developer.board.service.BoardService;
import com.developer.board.vo.BoardVO;
import com.developer.control.Controller;
import com.developer.exception.FindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;



public class AddBoardController implements Controller {
	
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
	//	response.addHeader("Access-Control-Allow-Credentials", "true");//쿠키 허용
		
		int maxPostSize = 100*1024;
		String encoding = "UTF-8";
		String saveDirectory = "/Users/choigeunhyeong/Documents/Developer/DeveloperFront/image/boardImg";
		MultipartRequest mr = new MultipartRequest(request, saveDirectory, maxPostSize, encoding);
		//int postSeq = Integer.parseInt(request.getParameter("postSeq"));
		int category = Integer.parseInt(mr.getParameter("category"));
		//int category =2;
		String userId = mr.getParameter("userId");
		String title = mr.getParameter("title");
		String content = mr.getParameter("content");
		String imgPath = mr.getParameter("imgPath");
		
		
		//File file = mr.getFile("f");
		File[] files = new File(saveDirectory).listFiles();
		for(File file: files) {
			String fileName = file.getName();
			long fileLength = file.length();
			System.out.println("fileName=" + fileName + ", fileLength=" + fileLength);
	
			//폴더생성
			//String subDirectory = fileName.substring(0, 1);//C G
			File dir = new File(saveDirectory);
			if(!dir.exists()) {
				dir.mkdir();
			}		
			//파일 옮기기
			//File origin = new File(saveDirectory, fileName);//원본
			File origin = new File(saveDirectory, fileName);//원본
			
			File copy = new File(dir, UUID.randomUUID() + "_" + fileName); //복사본
			
			//1)원본읽기
			FileInputStream fis = null;
			fis = new FileInputStream(origin);
			
			//2)복사본붙여넣기
			FileOutputStream fos = null;
			fos = new FileOutputStream(copy);
			
			int readValue = -1;
			while((readValue = fis.read()) != -1) {
				fos.write(readValue);
			}
			
			fos.close();
			fis.close();
			
			//3)원본삭제
			origin.delete();
		}
		BoardService service = new BoardService();
		ObjectMapper mapper = new ObjectMapper();
		try {
			service.addBoard(new BoardVO(0, userId, category, title, content, imgPath, null, 0, 0));
			System.out.println("게시글업롣");
		} catch (FindException e) {
			e.printStackTrace();
			Map<String, String> map = new HashMap<>();
			map.put("msg", e.getMessage());
			String jsonStr = mapper.writeValueAsString(map);
			return jsonStr;
		}
		
		return null;
		
	}
	
//	private void download(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("application/json;charset=UTF-8");
//		response.addHeader("Access-Control-Allow-Origin", "*");
//		//response.addHeader("Access-Control-Allow-Credentials", "true");//쿠키 허용
//		//요청데이터로 전달된 no
//		String fileName = request.getParameter("no");
//		String opt = request.getParameter("opt");
//		String saveDirectory = "/Users/choigeunhyeong/Documents/Developer/DeveloperFront/image/boardImg";
//		String subDirectory = fileName.substring(0,1); //서브디렉토리명
//		File dir = new File(saveDirectory, subDirectory);
//		dir.listFiles(); // 디렉토리 내부의 파일목록 배열
//		File[] files = dir.listFiles();
//		for(File f:files) {
//			if(f.getName().split("_")[1].equals(fileName)){// 혹은 split으로_뒤쪽을 꺼내서 c0001을 정확히찾아내기 위해서
//				//찾은경우
//					//응답헤더 설정
//				//nio..? 라이브러리에서 찾는
//				String contentType = Files.probeContentType(f.toPath()); //파일의 형식 jpg뿐아니라 pdf,등등 여러개도 올릴수있게
//				response.setHeader("Content-type", contentType);//응답형식
////					response.setHeader("Content-Type", "image/jpg");
//					response.setHeader("Content-Length", ""+f.length());
//					if("attachment".equals(opt)) {//다운로드
//					//아래두개는 둘중하나만 사용
//					//response.setHeader("content-disposition", "inline;filename=" + f.getName()); //바로응답. 한글깨짐 현상나오면 한글파일 인코딩
//					response.setHeader("content-disposition", "attachment;filename=" + f.getName());//다운로드 방법 attachment;filename=" filename: 다운로드될 파일이름 다른것으로 바꿔도됨
//					}else {//attachment가아니면 바로응답
//						response.setHeader("content-disposition", "inline;filename=" + f.getName()); //바로응답. 한글깨짐 현상나오면 한글파일 인코딩
//					}
//					FileInputStream fis = new FileInputStream(f);
//					OutputStream os = response.getOutputStream();
//					int readValue = -1;
//					while((readValue = fis.read())!= -1) {//응답 바디에 채울 내용부분 while
//						os.write(readValue);
//					}
//			}//백엔드가 클라이언트에게 응답할땐 정확하게 알려줘야함(몇바이트로 응답할것이고.. 등등)
//			//브랜치테스트
//			
//		}
//		//찾지못한경우
//		
//		
//	}

}
