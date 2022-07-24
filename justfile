# justfile (see https://just.systems/man/en/ for docs on "just")
goal +MESSAGE:
    git pull --rebase
    git commit --allow-empty -m "Goal: {{MESSAGE}}"
    git push

commit:
    @git add .
    -@git commit -am "wip"

# requires Maven Daemon: install with SDKMAN: 'sdk install mvnd'
# more docs at: https://github.com/apache/maven-mvnd
test:
    clear
    @mvnd test

integrate:
    git pull --rebase
    just test
    just commit
    git push

# requires watchexec: install with Homebrew: 'brew install watchexec'
# more docs at: https://github.com/watchexec/watchexec#install
tdd:
    watchexec -e java just test

ci:
    watchexec -e java just integrate

revert:
    @git reset --hard &> /dev/null
    @git clean -df &> /dev/null
    @echo -e "\033[0;31m=== REVERTED ==="
