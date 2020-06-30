package com.example.stpringbootjsp.service.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

	//	private final Path root = Paths.get("/uploads");

	/**
	 * ディレクトリー作成
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
	public boolean save(MultipartFile file, Path path) throws Exception {
		boolean result = false;
		try {
			// StandardCopyOption.REPLACE_EXISTINGオプションを指定して、上書き保存
			Files.copy(file.getInputStream(), path.resolve(file.getOriginalFilename()),
															StandardCopyOption.REPLACE_EXISTING);
			result = true;
		} catch (IOException ex) {
			throw new Exception(ex);
		}
		return result;
	}

	/**
	 * ファイルを移動
	 *
	 * @param file
	 * @throws Exception
	 */
	public boolean move(Path orgPath, Path targetPath) throws Exception {
		boolean result = false;
		try {
			// StandardCopyOption.REPLACE_EXISTINGオプションを指定して、上書き保存
			Files.move(orgPath, targetPath, StandardCopyOption.REPLACE_EXISTING);
			result = true;
		} catch (IOException ex) {
			throw new Exception(ex);
		}
		return result;
	}

	/**
	 * ファイルロード
	 *
	 * @param filename
	 * @param filePath
	 * @return
	 * @throws Exception
	 */
	public Resource load(String filename, String filePath) throws Exception {
		Path path = Paths.get(filePath);
		Path file = path.resolve(filename);
		Resource resource = new UrlResource(file.toUri());

		return resource;
//		try {
//			Path path = Paths.get(filePath);
//			Path file = path.resolve(filename);
//			Resource resource = new UrlResource(file.toUri());
//
//			return resource;
//			if (resource.exists() || resource.isReadable()) {
//				return resource;
//			} else {
//				throw new RuntimeException("Could not read the file!");
//			}
//		} catch (MalformedURLException e) {
//			throw new RuntimeException("Error: " + e.getMessage());
//		}
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

//    public String saveTemporaryFile(MultipartFile file, Path path)
//        throws IOException {
//
//        String uploadTemporaryFileId = UUID.randomUUID().toString();
////        File uploadTemporaryFile = new File(uploadTemporaryDirectory, uploadTemporaryFileId);
//
//        Files.copy(file.getInputStream(), path.resolve(file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
//
//        return uploadTemporaryFileId;
//    }



	//	public Stream<Path> loadAll() {
	//		try {
	//			return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
	//		} catch (IOException e) {
	//			throw new RuntimeException("Could not load the files!");
	//		}
	//	}
}
