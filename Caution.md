- 前端页面写在`web`目录下，不要放在`WEB-INF`目录中，在`web`目录下可以建`js`、`css`等文件夹。

- 后端所需要的`jar`包同意放置在`web`目录下`WEB-INF`中。

- 不要在本地的`master`分支上进行开发，每个人建立一个分支，在分支中进行开发。如果一天中写了点东西的话一定要`push`到自己远程的仓库的对应分支上（如果只`git commit`没有`git push origin <分支名>`，第二天拉取最新版本时可能会有冲突），约定每天***最晚9点***在github上提交请求（提交请求的时候，最好写一下自己这一天实现的功能，或者存在哪些bug），我会在9点之后对所有的请求进行合并。第二天早上，大家就可以同时获得最新的版本。

- 每天第一件事就是，更新一下自己的master和自己建的分支（`git pull upstream master`）。多`commit`，防止自己写的代码无法回退。

- `git add`的时候，不要直接`git add .`（全部添加），要一个文件一个文件`add`，目的是防止一些idea软件自动生成的文件混入其中。
