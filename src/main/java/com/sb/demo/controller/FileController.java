
	package com.sb.demo.controller;

	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.List;

	import javax.servlet.annotation.MultipartConfig;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpSession;

	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.MediaType;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.multipart.MultipartFile;
	import org.springframework.web.servlet.ModelAndView;

	import com.sb.demo.dao.UploadModel;



	@Controller
	public class FileController {

		@Autowired
		UploadModel uploadModel;
		
		@RequestMapping("/")
		public String displayUpload() {
			return "upload.jsp";
		}
		
		@PostMapping(path="/readData",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
		public String readData(@RequestParam(name="excelData") MultipartFile excelData,HttpServletRequest req) throws IOException {
			HttpSession session=req.getSession();
			List<UploadModel> employeeData=new ArrayList<UploadModel>();
			
			XSSFWorkbook workbook = new XSSFWorkbook(excelData.getInputStream());
	        XSSFSheet worksheet = workbook.getSheetAt(0);
	        
	        for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
	        	XSSFRow row = worksheet.getRow(i);
	        	uploadModel=new UploadModel();
	        	uploadModel.setEmployeeId((int)row.getCell(0).getNumericCellValue());
	        	uploadModel.setEmployeeName(row.getCell(1).getStringCellValue());
	        	uploadModel.setDepartment(row.getCell(2).getStringCellValue());
	        	uploadModel.setMobile(row.getCell(3).getStringCellValue());
	        	employeeData.add(uploadModel);
	        }
	        session.setAttribute("employeeData", employeeData);
	        return "display.jsp";
		}
		
	}

