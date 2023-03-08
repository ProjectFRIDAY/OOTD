package OOTD.demo.dress.controller;

import OOTD.demo.common.HttpResponseUtil;
import OOTD.demo.dress.dto.PostDressReq;
import OOTD.demo.dress.dto.UpdateDressReq;
import OOTD.demo.dress.service.DressService;
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

    @GetMapping("/{id}")
    public ResponseEntity<?> getSingleDress(@PathVariable Long id) {

        return httpResponseUtil.createOkHttpResponse(dressService.getSingleDress(id), "조회에 성공했습니다.");

    }

    @GetMapping
    public ResponseEntity<?> getDressList() {

        return httpResponseUtil.createOkHttpResponse(dressService.getDressList(), "조회에 성공했습니다.");

    }

    @PostMapping
    public ResponseEntity<?> createDress(@RequestPart @Valid PostDressReq req, @RequestPart MultipartFile file) {

        return httpResponseUtil.createOkHttpResponse(dressService.createDress(req, file), "생성에 성공했습니다.");

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDress(@PathVariable Long id, @RequestPart @Valid UpdateDressReq req,
                                         @RequestPart MultipartFile file) {

        return httpResponseUtil.createOkHttpResponse(dressService.updateDress(req, file), "수정에 성공했습니다.");

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSingleDress(@PathVariable Long id) {

        dressService.deleteSingleDress(id);
        return httpResponseUtil.createOkHttpResponse(null, "삭제에 성공했습니다.");

    }

}
