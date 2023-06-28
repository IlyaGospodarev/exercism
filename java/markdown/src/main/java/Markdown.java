class Markdown {

    String parse(String markdown) {
        String[] lines = markdown.split("\n");
        StringBuilder result = new StringBuilder();
        boolean activeList = false;

        for (String line : lines) {
            String parsedLine = parseHeader(line);

            if (parsedLine == null) {
                parsedLine = parseListItem(line);
            }

            if (parsedLine == null) {
                parsedLine = parseParagraph(line);
            }

            if (parsedLine.startsWith("<li>") && !parsedLine.startsWith("<h") && !parsedLine.startsWith("<p>") && !activeList) {
                activeList = true;
                result.append("<ul>");
            } else if (!parsedLine.startsWith("<li>") && activeList) {
                activeList = false;
                result.append("</ul>");
            }

            result.append(parsedLine);
        }

        if (activeList) {
            result.append("</ul>");
        }

        return result.toString();
    }

    private String parseHeader(String markdown) {
        int count = 0;

        while (count < markdown.length() && markdown.charAt(count) == '#') {
            count++;
        }

        if (count == 0) {
            return null;
        }

        return "<h" + count + ">" + markdown.substring(count + 1) + "</h" + count + ">";
    }

    private String parseListItem(String markdown) {
        if (markdown.startsWith("*")) {
            String listItem = markdown.substring(2);
            return "<li>" + parseSomeSymbols(listItem) + "</li>";
        }

        return null;
    }

    private String parseParagraph(String markdown) {
        return "<p>" + parseSomeSymbols(markdown) + "</p>";
    }

    private String parseSomeSymbols(String markdown) {
        String[] patterns = {
                "__(.+?)__", "<strong>$1</strong>",
                "_(.+?)_", "<em>$1</em>"
        };

        for (int i = 0; i < patterns.length; i += 2) {
            markdown = markdown.replaceAll(patterns[i], patterns[i + 1]);
        }

        return markdown;
    }
}
