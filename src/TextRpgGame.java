// TextRpgGame 클래스는 텍스트 기반 RPG 게임의 진행을 관리합니다.
public class TextRpgGame {
    // player1과 player2는 게임에 참여하는 두 플레이어의 객체입니다.
    private final Player player1;
    private final Player player2;

    // 생성자: 게임을 시작할 때 두 플레이어를 초기화합니다.
    public TextRpgGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    // playGame 메소드: 게임의 주요 로직을 실행합니다.
    public void playGame() {
        // 게임은 두 플레이어의 체력이 모두 0 이상일 때까지 계속됩니다.
        while(player1.getHealthPower() > 0 && player2.getHealthPower() > 0) {
            // 각 플레이어의 현재 상태(체력, 공격력, 방어력)를 로컬 변수에 저장합니다.
            int healthOfPlayer1 = player1.getHealthPower();
            int healthOfPlayer2 = player2.getHealthPower();
            int attackPowerOfPlayer1 = player1.getAttackPower();
            int attackPowerOfPlayer2 = player2.getAttackPower();
            int defensePowerOfPlayer1 = player1.getDefensePower();
            int defensePowerOfPlayer2 = player2.getDefensePower();

            // 전투 상황을 시각적으로 구분하기 위한 구분선을 출력합니다.
            System.out.println("-".repeat(40));
            System.out.printf("[안내] [%s]유닛이 [%s] 유닛을 [공격] 하였습니다.%n", player1.getName(), player2.getName());

            // 플레이어2의 체력을 갱신합니다. 공격 결과는 공격력과 방어력의 비율로 계산됩니다.
            player2.setHealthPower(healthOfPlayer2 - getAttackPoint(attackPowerOfPlayer1, defensePowerOfPlayer2));
            if(player2.getHealthPower() > 0) System.out.printf("[안내] %s 유닛의 남은 [체력]은 %d입니다.%n", player2.getName(), player2.getHealthPower());

            // 구분선을 다시 출력합니다.
            System.out.println("-".repeat(40));
            System.out.printf("[안내] [%s]유닛이 [%s] 유닛을 [공격] 하였습니다.%n", player2.getName(), player1.getName());

            // 플레이어1의 체력을 갱신합니다. 공격 결과는 동일하게 계산됩니다.
            player1.setHealthPower(healthOfPlayer1 - getAttackPoint(attackPowerOfPlayer2, defensePowerOfPlayer1));
            if(player1.getHealthPower() > 0) System.out.printf("[안내] %s 유닛의 남은 [체력]은 %d입니다.%n", player1.getName(), player1.getHealthPower());
        }

        // 게임이 끝났을 때, 죽은 플레이어의 이름을 저장하고 출력합니다.
        String currentDeathPlayerName = player1.getHealthPower() <= 0 ? player1.getName() : player2.getName();
        System.out.println("-".repeat(40));
        System.out.println("[안내] 더 이상 공격할 수 없습니다.");
        System.out.printf("[안내] %s 유닛이 사망했습니다.%n", currentDeathPlayerName);
    }

    // getAttackPoint 메소드: 공격력과 방어력을 바탕으로 실제 공격 점수를 계산합니다.
    private int getAttackPoint(int attackPowerPlayer1, int defensePowerPlayer2) {
        // 공격 점수는 공격력을 방어력으로 나눈 몫입니다.
        return attackPowerPlayer1 / defensePowerPlayer2;
    }
}
