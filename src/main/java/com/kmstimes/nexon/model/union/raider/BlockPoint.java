package com.kmstimes.nexon.model.union.raider;

/**
 * 메이플스토리 유니온 블록 기준점 좌표를 담는 데이터 클래스입니다.
 * <p>
 * <strong>블록 기준점 좌표:</strong>
 * <ul>
 * <li>중앙 4칸 중 오른쪽 아래 칸이 x : 0, y : 0 포지션</li>
 * <li>좌측으로 1칸씩 이동하면 x가 1씩 감소</li>
 * <li>우측으로 1칸씩 이동하면 x가 1씩 증가</li>
 * <li>아래로 1칸씩 이동하면 y가 1씩 감소</li>
 * <li>위로 1칸씩 이동하면 y가 1씩 증가</li>
 * </ul>
 *
 * @param x 블록 기준점 X좌표
 * @param y 블록 기준점 Y좌표
 */
public record BlockPoint(
        Long x,
        Long y
) {
}
