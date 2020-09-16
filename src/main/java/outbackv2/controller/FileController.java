package outbackv2.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j2;
import outbackv2.dto.FilesDto;
import outbackv2.dto.FilesResDto;
import outbackv2.service.FilesService;


@Log4j2
@Controller
public class FileController {
	
	@Autowired
	private FilesService service;
	
	@GetMapping("/file/list")
	public String list(Model model) {
		List<FilesResDto>list=service.findAll();
		model.addAttribute("list", list);
		return "/event/list";
	}
	
	@GetMapping("/file/reg")
	public String reg() {
		return "/event/reg";
	}
	
	@PostMapping("/file/reg")
	public String reg(FilesDto dto, MultipartFile fileInfo) throws IllegalStateException, IOException {
		String fileName=fileInfo.getOriginalFilename();
		dto.setFileName(fileName);
		//파일 업로드
		ClassPathResource cr=new ClassPathResource("static/upload"); //bin에 저장됨
		File dir=cr.getFile();
		File dest=new File(dir,fileName);
		//File dest=new File("C:/Users/82103/Desktop/workspace/outback/src/main/resources/static/upload/"+FileName);
		fileInfo.transferTo(dest);
		log.debug(dto);
		//DB에 dto저장
		service.save(dto);
		return "redirect:/file/list";
	}
	
	@GetMapping("/file/delete/{no}")
	public String delete(@PathVariable Long no) {
		service.delete(no);
		return "redirect:/file/list";
	}

}
