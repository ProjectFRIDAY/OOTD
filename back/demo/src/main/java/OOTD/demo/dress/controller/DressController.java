package OOTD.demo.dress.controller;

import OOTD.demo.common.HttpResponseUtil;
import OOTD.demo.dress.dto.PostDressReq;
import OOTD.demo.dress.dto.UpdateDressReq;
import OOTD.demo.dress.service.DressService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

/**
 * Dress 관련 컨트롤러 클래스입니다.
 *
 * @author CHO Min Ho
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dress")
@Slf4j
public class DressController {

    private final DressService dressService;
    private final HttpResponseUtil httpResponseUtil;

    @Operation(summary = "단일 옷 조회 API", description = "단일 옷 조회 API 입니다.", tags = { "Dress Controller" })
    @GetMapping("/{id}")
    public ResponseEntity<?> getSingleDress(@PathVariable Long id) {

        return httpResponseUtil.createOkHttpResponse(dressService.getSingleDress(id), "조회에 성공했습니다.");

    }

    @Operation(summary = "옷 리스트 조회 API", description = "옷 리스트 조회 API 입니다.", tags = { "Dress Controller" })
    @GetMapping
    public ResponseEntity<?> getDressList() {

        return httpResponseUtil.createOkHttpResponse(dressService.getDressList(), "조회에 성공했습니다.");

    }

    @Operation(summary = "옷 생성 API", description = "옷 생성 API 입니다.", tags = { "Dress Controller" })
    @PostMapping
    public ResponseEntity<?> createDress(@RequestPart @Valid PostDressReq req, @RequestPart MultipartFile file) {

        return httpResponseUtil.createOkHttpResponse(dressService.createDress(req, file), "생성에 성공했습니다.");

    }

    @Operation(summary = "옷 수정 API", description = "옷 수정 조회 API 입니다.", tags = { "Dress Controller" })
    @PutMapping("/{id}")
    public ResponseEntity<?> updateDress(@PathVariable Long id, @RequestPart @Valid UpdateDressReq req,
                                         @RequestPart MultipartFile file) {

        return httpResponseUtil.createOkHttpResponse(dressService.updateDress(req, file), "수정에 성공했습니다.");

    }

    @Operation(summary = "옷 삭제 API", description = "옷 삭제 API 입니다.", tags = { "Dress Controller" })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSingleDress(@PathVariable Long id) {

        dressService.deleteSingleDress(id);
        return httpResponseUtil.createOkHttpResponse(null, "삭제에 성공했습니다.");

    }

    @Operation(summary = "옷 검색 API", description = "옷 검색 API 입니다.", tags = { "Dress Controller" })
    @GetMapping("/search")
    public ResponseEntity<?> searchDress(@RequestParam String searchStr) {

        log.info("검색어 : {}", searchStr);
        return httpResponseUtil.createOkHttpResponse(dressService.searchDress(searchStr), "검색에 성공했습니다.");
    }

}
