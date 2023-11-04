# git add, git commit, and git push all in one from local repository to remote repository
# https://stackoverflow.com/questions/6143285/git-add-vs-push-vs-commit

git add . # note the working directory when executing bash
git commit -a -m "$1"
git push