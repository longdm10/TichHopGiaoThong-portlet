/**
 * 
 */
package vn.gt.portlet.kehoach1;

import vn.gt.utils.document.ResultUpload;

/**
 * @author win_64
 *
 */
public interface IDocumentStorage {
	public ResultUpload upload(Long userId, byte[] b, String fileName);
	
	public void deleteFile(Long documentId);
	
	public String getURLById(Long fileId);
	
	public String getFileName(String fileName,String newName);
	public boolean existFile(Long fileId);
}
