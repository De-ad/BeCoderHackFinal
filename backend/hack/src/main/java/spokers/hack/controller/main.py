import requests
import sys

url = sys[1]
user = "netwid"
repo = "crypto-auction"
branch = ""

resp = None
if branch == "":
    resp = requests.get(url)
else:
    resp = requests.get(url + "")
"""
if branch == "":
    resp = requests.get(f"https://api.github.com/repos/{user}/{repo}/commits")
else:
    resp = requests.get(f"https://api.github.com/repos/{user}/{repo}/commits/{branch}")
"""



def compare(author, parent_url, own_url, date, unfixed):
    req_url = f"https://api.github.com/repos/{user}/{repo}/compare/{parent_url}...{own_url}"
    changes = requests \
        .get(req_url) \
        .json()
    for file in changes['files']:
        print(author, file['filename'], unfixed, date)


def init_commit(author, files, unfixed, date):
    for file in files:
        print(author, file['filename'], unfixed, date)


for commit in resp.json():
    info = commit['commit']
    unfixed = True
    if "fix" in info['message'].lower():
        unfixed = False
    commit_author = info['author']['name']
    parent = commit['parents']
    own_url = commit['sha'][:7:]
    try:
        parent_url = parent[0]['sha'][:7:]
        compare(commit_author, parent_url, own_url, info['author']['date'], unfixed)
    except IndexError:
        to_commit = requests \
            .get(f"https://api.github.com/repos/{user}/{repo}/commits/{own_url}") \
            .json()
        init_commit(commit_author, to_commit['files'], True, info['author']['date'])