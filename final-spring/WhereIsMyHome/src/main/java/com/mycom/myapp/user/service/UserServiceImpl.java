package com.mycom.myapp.user.service;

import com.mycom.myapp.user.dto.User;
import com.mycom.myapp.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Value("${app.fileupload.uploadPath}")
    String uploadPath;

    @Value("${app.fileupload.uploadFoler}")
    String uploadFolder;

    @Override
    public User join(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user, MultipartHttpServletRequest request) throws IOException {
        User changeUser = userRepository.findById(user.getId()).get();

        changeUser.setUserEmail(user.getUserEmail());
        changeUser.setUserName(user.getUserName());

        List<MultipartFile> fileList = request.getFiles("file");

        for (MultipartFile partFile : fileList) {
            String fileName = partFile.getOriginalFilename(); // 첨부된 원래 파일 명, 이 이름으로는 바로 저장하지 않고 UUID 를 이용해서 중복불가한 파일 이름을 만든다.

            // Random UUID File id
            UUID uuid = UUID.randomUUID();

            // 파일 확장자
            String extension = FilenameUtils.getExtension(fileName); // 원래 파일의 확장자만 추출

            // 실제 저장할 파일 전체 이름은
            String savingFileName = uuid + "." + extension;

            File destFile = new File(uploadPath + File.separator + uploadFolder + File.separator + savingFileName);

            // 파일 객체를 통해서 파일을 저장
            partFile.transferTo(destFile);

           changeUser.setUserProfileImageUrl(uploadFolder + "/" + savingFileName);
        }

        return changeUser;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> listUser(int limit, int pageUnit) {
        Pageable pageable = PageRequest.of(pageUnit, limit);
        Page<User> page = userRepository.findAll(pageable);
        return page.toList();
    }
    
	@Override
	public long countUser() {
		return userRepository.count();
	}
}
