import java.util.Scanner;

// TextRpgGameApplication 클래스: 게임 실행을 위한 메인 클래스입니다.
public class TextRpgGameApplication {
    // scanner 객체: 사용자 입력을 처리하기 위한 Scanner 객체입니다.
    private static Scanner scanner = new Scanner(System.in);
    // ME_PLAYER_INPUT_GUIDE_MESSAGE: 첫 번째 플레이어(사용자)의 유닛 정보 입력 안내 메시지
    private final static String ME_PLAYER_INPUT_GUIDE_MESSAGE = "[안내] 자신의 유닛 정보를 입력해 주세요.";
    // ANOTHER_PLAYER_INPUT_GUIDE_MESSAGE: 두 번째 플레이어(상대)의 유닛 정보 입력 안내 메시지
    private final static String ANOTHER_PLAYER_INPUT_GUIDE_MESSAGE = "[안내] 상대 유닛 정보를 입력해 주세요.";

    // main 메소드: 프로그램의 진입점
    public static void main(String[] args) {
        // 환영 메시지 출력
        displayWelcomeMessage();

        // 플레이어1 정보 입력 및 생성
        Player player1 = createPlayer(ME_PLAYER_INPUT_GUIDE_MESSAGE);

        // 플레이어1 정보 출력
        displayPlayerInfomation(player1);

        // 플레이어2 정보 입력 및 생성
        Player player2 = createPlayer(ANOTHER_PLAYER_INPUT_GUIDE_MESSAGE);
        // 플레이어2 정보 출력
        displayPlayerInfomation(player2);

        // 게임 로직 실행
        playGame(player1, player2);
    }

    // playGame 메소드: 게임을 시작하는 메소드로, TextRpgGame 객체를 생성하여 게임을 시작합니다.
    private static void playGame(Player player1, Player player2) {
        TextRpgGame textRpgGame = new TextRpgGame(player1, player2);
        textRpgGame.playGame();
    }

    // displayWelcomeMessage 메소드: 게임 시작 시 환영 메시지를 출력합니다.
    private static void displayWelcomeMessage() {
        System.out.println("[안내] TRPG 스타크래프트 게임을 시작합니다.");
    }

    // createPlayer 메소드: 플레이어의 정보를 입력 받아 Player 객체를 생성합니다.
    private static Player createPlayer(String str) {
        System.out.println(str);
        System.out.printf("[시스템] 유닛 [이름]을 입력해 주세요: ");
        String name = scanner.nextLine().trim();
        System.out.printf("[시스템] 유닛 [공격력]을 입력해 주세요: ");
        int attackPower = Integer.parseInt(scanner.nextLine().trim());
        System.out.printf("[시스템] 유닛 [방어력]을 입력해 주세요: ");
        int defensePower = Integer.parseInt(scanner.nextLine().trim());
        System.out.printf("[시스템] 유닛 [체력]을 입력해 주세요: ");
        int healthPower = Integer.parseInt(scanner.nextLine().trim());
        System.out.printf("[시스템] 유닛 [종족]을 입력해 주세요: ");
        Tribe tribe = new Tribe(scanner.nextLine().trim());
        return new Player(name, attackPower, defensePower, healthPower, tribe);
    }

    // displayPlayerInfomation 메소드: 생성된 플레이어의 정보를 출력합니다.
    private static void displayPlayerInfomation(Player player) {
        System.out.println("[안내] 생성된 유닛의 정보는 다음과 같습니다.");
        System.out.printf("[안내] %s유닛이 게임에 참여하였습니다. %n", player.getName());
        System.out.printf("[공격력] : %d%n", player.getAttackPower());
        System.out.printf("[방어력] : %d%n", player.getDefensePower());
        System.out.printf("[체력] : %d%n", player.getHealthPower());
        System.out.println("=".repeat(40));
    }
}
