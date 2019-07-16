package guestbook.model;

import java.util.List;

public class MessageListView {

	private int messageTotalCount;
	private int currentPageNumber;//현재페이지 넘버가 무엇으로 되어있는지
	private List<Message> messageList;
	private int pageTotalCount;
	private int messageCountPerPage;
	private int firstRow;
	private int endRow;
	
	
	public MessageListView(int messageTotalCount, int currentPageNumber, List<Message> messageList, 
			int messageCountPerPage, int firstRow, int endRow) {
		super();
		this.messageTotalCount = messageTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.messageList = messageList;
		//this.pageTotalCount = pageTotalCount; : 초기값을 생성해줄거임 따로
		this.messageCountPerPage = messageCountPerPage;
		this.firstRow = firstRow;
		this.endRow = endRow;
		calcuratePageTotalCount();
	}
	
	
	private void calcuratePageTotalCount() {
		// TODO Auto-generated method stub
		//개수세는거라 0보다 작은건없음
		if(messageTotalCount == 0) {
			pageTotalCount = 0;
		}else {
			pageTotalCount = messageTotalCount / messageCountPerPage;
			
			if(messageTotalCount%messageCountPerPage > 0) {
				pageTotalCount++;
			}
		}
	}

	
	public int getMessageTotalCount() {
		return messageTotalCount;
	}
	public void setMessageTotalCount(int messageTotalCount) {
		this.messageTotalCount = messageTotalCount;
	}
	public int getCurrentPageNumber() {
		return currentPageNumber;
	}
	public void setCurrentPageNumber(int currentPageNumber) {
		this.currentPageNumber = currentPageNumber;
	}
	public List<Message> getMessageList() {
		return messageList;
	}
	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}
	public int getPageTotalCount() {
		return pageTotalCount;
	}
	public void setPageTotalCount(int pageTotalCount) {
		this.pageTotalCount = pageTotalCount;
	}
	public int getMessageCountPerPage() {
		return messageCountPerPage;
	}
	public void setMessageCountPerPage(int messageCountPerPage) {
		this.messageCountPerPage = messageCountPerPage;
	}
	public int getFirstRow() {
		return firstRow;
	}
	public void setFirstRow(int firstRow) {
		this.firstRow = firstRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	
	
	public boolean isEmpty() {
		return messageCountPerPage == 0;
	}
	
	
}
