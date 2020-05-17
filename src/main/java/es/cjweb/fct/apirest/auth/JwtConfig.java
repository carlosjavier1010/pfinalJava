package es.cjweb.fct.apirest.auth;

public class JwtConfig {
	
	public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";
	
	public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\r\n" + 
			"MIIEpAIBAAKCAQEA0gbWYWf7F31kRKF9B9Ng5T4skEd7U6KdIezJgPCPjflUuGSV\r\n" + 
			"pIF0Jvpqw8dudBtCSIiN1bT3OsggoyVmX6oLoHL4nzcIFrJC61eNo/UOXNBGPdTT\r\n" + 
			"P8uo3QZXMdY+1dNt+Grqmemj+pd21NmimGhTZdioYFwL9NcWy7AHSgXW/wGFVTzd\r\n" + 
			"YfA1zadn5HiJIw1SUP+z11ihRH2BIQk9jqy0g1fMkuanhUDnQ7BkokkFWiIJtPUR\r\n" + 
			"Bw1xTYBP6Tps2gM5skbH9YVbMCXdFdJgx/pbFDGoeE0mWT6ujeZXPQ/trAUqPvlS\r\n" + 
			"ziWZbWuNupMR21H9wIbaTYbnBN6VLJAwxfNPGQIDAQABAoIBAQCxsPU5rfaC9iSZ\r\n" + 
			"6CLXNyA4c3TSkJent+HHbQVCoMRjsrnZ08fDSX8S5zTi9NzfQJzArz+IujWdNupd\r\n" + 
			"/WtyrnRtyDfOxImEYkc5w3ZjbBY9sjxrXZ9ozw7MCOxGjuPUlq/ox9Q6abDBd9oi\r\n" + 
			"1Qq6dTFx7m7uL5IyELQJmqFgIDa4wXFG8vok/gRHmJ6ujzk0s8t7Bgvjej99bMgV\r\n" + 
			"KKwP5gnygPFads/hU3XaV7UboNnozXC6tl3U7+vWsMgBxdlp6C+W8kOQTKWvGzXc\r\n" + 
			"+UqYJSuqG/oRvh78rN1UWBu//1YMvLnnuQDnMZvTvV+Z+CUeNuvCFI8XTTwPyvwf\r\n" + 
			"+1AOTOStAoGBAOjXapsDUryWo9LHFPBUJBDpNlTX6rd+NCJ73FMl++OkwtEaXyZV\r\n" + 
			"HT9zQmKnfkPXwkXOVaWRtImOf4A1saXoOlOa5nxKT0yhMv6uV4/BIcTPbumMvWU0\r\n" + 
			"Bzyx/yurog7xsuyFy9ZX67Bt5ZaGZqp2dgLAjUuFCH2Y/mp5JpHjFXx/AoGBAObq\r\n" + 
			"g5puIKkJAX6Kli/LX+AK4WYCNBu0XLCJoHb/zirBeN6zRVrgF6ex7oQNr1/dkDIB\r\n" + 
			"xAjrpn7Ov7xeBelRvy171FGoueoagNeigySbTrWyA9TDu/a1WMnzZ/+eQBB4pSjr\r\n" + 
			"7avjD5cmjNDTVlN3GwfYLeQRxz0wsJkW4APHdchnAoGBAN0kW1fGnDoJSKbT9gsb\r\n" + 
			"nvWAyd1jBMYp0xI9WVCPbuEShwVaaqxZgmHU8mQIeF+u+BCcm7OY40MSV/5JAOR1\r\n" + 
			"34+wOuApI4/AOlKw+vDJmWz3Jnwi826/L3ByDcxIQq622BzUJnj5IBx9A+Um2TNl\r\n" + 
			"N0f94TSssRe4y0oMrpk4eBu5AoGAMfy0TnrmkREFBMqlZmVFNO/GCVoSw6iQpBq2\r\n" + 
			"5OvNSo4lRzhRnDGEjWXEN0vrGfqRm3GsaS3yFeNVuEY2S2LJ2uPCe4bl8Bqap5Nj\r\n" + 
			"hkokiMqnb6iLiQWK2fTaH4i3X5luT2R7R8lYd6T9uLr3JgxTiqgujv+WPNXMdOdx\r\n" + 
			"yP+lrKMCgYA2QGCkCgTw/O+trEgA+lHBj7Hyvzy1SV6N48hpRJansIT1kaveIEwp\r\n" + 
			"DgpF9nIEufNILoJ8UKAWjn+XMlMbjv2jjJAadti7+rllvZHn5Ov9Sr6GN5uJzhv3\r\n" + 
			"kBb0b36qw/HZebMZhoeqURVoclnetB3Y52UM65l336b00KEdn0cj/w==\r\n" + 
			"-----END RSA PRIVATE KEY-----";
	
		public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\r\n" + 
				"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA0gbWYWf7F31kRKF9B9Ng\r\n" + 
				"5T4skEd7U6KdIezJgPCPjflUuGSVpIF0Jvpqw8dudBtCSIiN1bT3OsggoyVmX6oL\r\n" + 
				"oHL4nzcIFrJC61eNo/UOXNBGPdTTP8uo3QZXMdY+1dNt+Grqmemj+pd21NmimGhT\r\n" + 
				"ZdioYFwL9NcWy7AHSgXW/wGFVTzdYfA1zadn5HiJIw1SUP+z11ihRH2BIQk9jqy0\r\n" + 
				"g1fMkuanhUDnQ7BkokkFWiIJtPURBw1xTYBP6Tps2gM5skbH9YVbMCXdFdJgx/pb\r\n" + 
				"FDGoeE0mWT6ujeZXPQ/trAUqPvlSziWZbWuNupMR21H9wIbaTYbnBN6VLJAwxfNP\r\n" + 
				"GQIDAQAB\r\n" + 
				"-----END PUBLIC KEY-----";
}
