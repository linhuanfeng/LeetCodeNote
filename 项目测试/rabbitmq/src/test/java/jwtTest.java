public class jwtTest {
    public static void main(String[] args) {
        String openId1="111111";
        String openId2="222222";
        String token1 = JwtUtil.generateJwtTokenHMAC(openId1);
        String token2 = JwtUtil.generateJwtTokenHMAC(openId2);
        System.out.println(JwtUtil.checkToken(token1));
        System.out.println(JwtUtil.checkToken(token2));
        String openId="eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySW5mbyI6IlwiMDEzMktWa2wyTHRSNTk0YTFSa2wyaG5FOHYxMktWa3lcIiIsImlzcyI6IkxIRiJ9.zCYYUMtOwa9dIvpo1z4Q3GNKy1nsLL1qWbZZlOZ2Rrk";
        System.out.println(JwtUtil.checkToken(openId));
    }
}
