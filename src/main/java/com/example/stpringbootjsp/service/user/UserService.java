package com.example.stpringbootjsp.service.user;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserService {

	//	private final Path root = Paths.get("/uploads");

	/**
	 * フォルダー作成
	 *
	 * @throws Exception
	 */
	public void makeDir(Path path) throws Exception {
		try {
			// フォルダの存在を確認する
			if (!Files.isDirectory(path)) {
				Files.createDirectory(path);
			}
		} catch (IOException e) {
			throw new Exception("Could not initialize folder for upload!");
		}
	}

	/**
	 * ファイルを保存
	 *
	 * @param file
	 * @throws Exception
	 */
	public void save(MultipartFile file, Path path) throws Exception {
		// StandardCopyOption.REPLACE_EXISTINGオプションを指定して、上書き保存
		Files.copy(file.getInputStream(), path.resolve(file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
	}

	/**
	 * ファイル削除
	 *
	 * @param targetPath
	 * @return
	 * @throws Exception
	 */
	public boolean delete(Path targetPath) throws Exception {
		boolean result = false;
		// 削除に成功するとtrueを返し、失敗するとfalseを返します
		if (Files.deleteIfExists(targetPath)) {
			// 削除OK
			result = true;
		}
		return result;
		//		FileSystemUtils.deleteRecursively(root.toFile());
	}

	//	public Resource load(String filename) throws Exception  {
	//		try {
	//			Path file = root.resolve(filename);
	//			Resource resource = new UrlResource(file.toUri());
	//
	//			if (resource.exists() || resource.isReadable()) {
	//				return resource;
	//			} else {
	//				throw new RuntimeException("Could not read the file!");
	//			}
	//		} catch (MalformedURLException e) {
	//			throw new RuntimeException("Error: " + e.getMessage());
	//		}
	//	}

	//	public Stream<Path> loadAll() {
	//		try {
	//			return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
	//		} catch (IOException e) {
	//			throw new RuntimeException("Could not load the files!");
	//		}
	//	}
}
