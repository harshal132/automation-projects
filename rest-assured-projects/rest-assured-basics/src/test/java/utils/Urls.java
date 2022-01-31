package utils;

public enum Urls {
	HOSTNAME("https://reqres.in"),
	LIST_USERS("/api/users?page=2"),
	SINGLE_USER("/api/users/2"),
	SINGLE_USER_NOT_FOUND("/api/users/23");
	
	private String value;
	Urls(String value) {
		this.value = value;
	}

    public String getValue() {
        return value;
    }
}
