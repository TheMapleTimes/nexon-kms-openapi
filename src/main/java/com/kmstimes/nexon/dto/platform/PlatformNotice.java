package com.kmstimes.nexon.dto.platform;

import java.util.List;

public record PlatformNotice(
        String game_name,
        String title,
        String url,
        String contents,
        String date,
        List<String> notice_tag
) {

}
